#!/bin/bash

# Test registration with enhanced error handling
# This script tests various registration scenarios

echo "=== Testing Registration with Enhanced Error Handling ==="
echo

# Test 1: Valid registration
echo "Test 1: Valid registration"
curl -X POST http://localhost:9100/auth/register \
  -H "Content-Type: application/json" \
  -d '{
    "username": "testuser202412",
    "password": "Test123456",
    "realName": "测试用户",
    "campusNum": "20241234567"
  }' \
  -w "\nHTTP Status: %{http_code}\n"
echo

# Test 2: Username too short
echo "Test 2: Username too short (should return validation error)"
curl -X POST http://localhost:9100/auth/register \
  -H "Content-Type: application/json" \
  -d '{
    "username": "ab",
    "password": "Test123456",
    "realName": "测试",
    "campusNum": "20241234568"
  }' \
  -w "\nHTTP Status: %{http_code}\n"
echo

# Test 3: Missing required field
echo "Test 3: Missing required field (should return validation error)"
curl -X POST http://localhost:9100/auth/register \
  -H "Content-Type: application/json" \
  -d '{
    "username": "testuser3",
    "password": "Test123456",
    "campusNum": "20241234569"
  }' \
  -w "\nHTTP Status: %{http_code}\n"
echo

# Test 4: Invalid campus number format
echo "Test 4: Invalid campus number format (should return validation error)"
curl -X POST http://localhost:9100/auth/register \
  -H "Content-Type: application/json" \
  -d '{
    "username": "testuser4",
    "password": "Test123456",
    "realName": "测试4",
    "campusNum": "2024123456"
  }' \
  -w "\nHTTP Status: %{http_code}\n"
echo

echo "=== Test completed ==="