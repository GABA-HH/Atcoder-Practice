param(
    [Parameter(Mandatory=$true)]
    [string]$ContestInput
)

$ErrorActionPreference = "Stop"

# Contest ID and Folder Name mapping
$contestId = ""
$folderName = ""

if ($ContestInput -match '^\d+$') {
    $num = [int]$ContestInput
    $numStr = $num.ToString("000")
    $contestId = "abc$numStr"
    $folderName = "Begginer$numStr"
}
else {
    if ($ContestInput -match '^(?i)abc(\d+)$') {
        $num = [int]$Matches[1]
        $numStr = $num.ToString("000")
        $contestId = "abc$numStr"
        $folderName = "Begginer$numStr"
    }
    else {
        $contestId = $ContestInput.ToLower()
        $folderName = $ContestInput.ToUpper()
    }
}

Write-Host "Fetching problems for contest '$contestId'..." -ForegroundColor Cyan

$problemIndexes = [System.Collections.Generic.List[string]]::new()

# 1. Fetch task list from official Web site
try {
    $url = "https://atcoder.jp/contests/$contestId/tasks"
    $webClient = New-Object System.Net.WebClient
    $webClient.Headers.Add("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64)")
    $webClient.Encoding = [System.Text.Encoding]::UTF8
    $html = $webClient.DownloadString($url)

    $pattern = "/contests/$contestId/tasks/${contestId}_([a-z0-9_]+)"
    $regexMatches = [regex]::Matches($html, $pattern)

    foreach ($m in $regexMatches) {
        $idx = $m.Groups[1].Value.ToUpper()
        if ($idx -match '^[A-Z0-9]+$') {
            if (-not $problemIndexes.Contains($idx)) {
                $problemIndexes.Add($idx)
            }
        }
    }
}
catch {
    Write-Host "Notice: Failed to fetch task list directly from AtCoder official web page." -ForegroundColor Yellow
}

# 2. Fallback using AtCoder Problems API
if ($problemIndexes.Count -eq 0) {
    try {
        $apiUrl = "https://kenkoooo.com/atcoder/resources/contest-problem.json"
        $problems = Invoke-RestMethod -Uri $apiUrl -UserAgent "Mozilla/5.0"
        foreach ($item in $problems) {
            if ($item.contest_id -eq $contestId) {
                $idx = $item.problem_index.ToUpper()
                if (-not $problemIndexes.Contains($idx)) {
                    $problemIndexes.Add($idx)
                }
            }
        }
    }
    catch {
        Write-Host "Notice: API fallback fetch failed." -ForegroundColor Red
    }
}

# 3. Default fallback (A ~ F)
if ($problemIndexes.Count -eq 0) {
    Write-Host "Using default problem list (A, B, C, D, E, F)." -ForegroundColor Yellow
    "A", "B", "C", "D", "E", "F" | ForEach-Object { $problemIndexes.Add($_) }
}

Write-Host "Target Contest : $contestId" -ForegroundColor Green
Write-Host "Folder Name    : $folderName" -ForegroundColor Green
Write-Host "Problems Found : $($problemIndexes -join ', ')" -ForegroundColor Green

# Create target directory
$targetDir = Join-Path $PSScriptRoot "..\src\main\java\$folderName"
if (-not (Test-Path $targetDir)) {
    New-Item -ItemType Directory -Path $targetDir -Force | Out-Null
    Write-Host "`nCreated folder: $targetDir" -ForegroundColor Green
}
else {
    Write-Host "`nTarget folder exists: $targetDir" -ForegroundColor Yellow
}

# Generate Java boilerplate files
foreach ($p in $problemIndexes) {
    $className = $p
    $filePath = Join-Path $targetDir "$className.java"

    if (-not (Test-Path $filePath)) {
        $template = "package $folderName;`n`nimport java.util.Scanner;`n`npublic class $className {`n    public static void main(String[] args) {`n        try (Scanner sc = new Scanner(System.in)) {`n            // TODO: Solve Problem $className`n        }`n    }`n}`n"
        [System.IO.File]::WriteAllText($filePath, $template, [System.Text.Encoding]::UTF8)
        Write-Host "  [+] Created: $className.java" -ForegroundColor Green
    }
    else {
        Write-Host "  [-] Skipped: $className.java (already exists)" -ForegroundColor Gray
    }
}

Write-Host "`nSuccessfully created $folderName files!" -ForegroundColor Cyan
