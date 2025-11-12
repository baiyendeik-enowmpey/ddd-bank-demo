#!/usr/bin/env bash
set -e
ROOT="ddd-bank-demo"
zip -r "${ROOT}.zip" "$ROOT"
echo "Created ${ROOT}.zip"
