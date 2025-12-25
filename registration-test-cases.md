# 用户注册功能测试用例

## 接口信息
- **URL**: `POST /auth/register`
- **Content-Type**: `application/json`
- **Base URL**: 请替换为您的实际服务地址

## 测试用例

### 1. 成功注册（新用户）
```json
POST /auth/register
{
    "username": "testuser202412",
    "password": "Test123456",
    "realName": "张三",
    "campusNum": "20241234567"
}
```
**预期响应**:
```json
{
    "code": 200,
    "msg": "操作成功",
    "data": "1234567890123456789"  // 用户ID
}
```

### 2. 验证失败 - 用户名格式错误（太短）
```json
POST /auth/register
{
    "username": "ab",
    "password": "Test123456",
    "realName": "王五",
    "campusNum": "20241111111"
}
```
**预期响应**:
```json
{
    "code": 400,
    "msg": "username: 用户名必须是4-20位字母、数字或下划线; ",
    "data": null
}
```

### 3. 验证失败 - 用户名格式错误（特殊字符）
```json
POST /auth/register
{
    "username": "test@user",
    "password": "Test123456",
    "realName": "赵六",
    "campusNum": "20242222222"
}
```
**预期响应**:
```json
{
    "code": 400,
    "msg": "username: 用户名必须是4-20位字母、数字或下划线; ",
    "data": null
}
```

### 4. 验证失败 - 密码格式错误（无数字）
```json
POST /auth/register
{
    "username": "testuser2",
    "password": "TestPassword",
    "realName": "钱七",
    "campusNum": "20243333333"
}
```
**预期响应**:
```json
{
    "code": 400,
    "msg": "password: 密码长度必须大于8位且包含字母和数字; ",
    "data": null
}
```

### 5. 验证失败 - 密码格式错误（无字母）
```json
POST /auth/register
{
    "username": "testuser3",
    "password": "123456789",
    "realName": "孙八",
    "campusNum": "20244444444"
}
```
**预期响应**:
```json
{
    "code": 400,
    "msg": "password: 密码长度必须大于8位且包含字母和数字; ",
    "data": null
}
```

### 6. 验证失败 - 学工号格式错误（不足11位）
```json
POST /auth/register
{
    "username": "testuser4",
    "password": "Test123456",
    "realName": "周九",
    "campusNum": "2024123456"
}
```
**预期响应**:
```json
{
    "code": 400,
    "msg": "campusNum: 学工号格式不正确; ",
    "data": null
}
```

### 7. 验证失败 - 学工号格式错误（非数字）
```json
POST /auth/register
{
    "username": "testuser5",
    "password": "Test123456",
    "realName": "吴十",
    "campusNum": "2024A123456"
}
```
**预期响应**:
```json
{
    "code": 400,
    "msg": "campusNum: 学工号格式不正确; ",
    "data": null
}
```

### 8. 验证失败 - 真实姓名过长
```json
POST /auth/register
{
    "username": "testuser6",
    "password": "Test123456",
    "realName": "这是一个非常长的姓名，超过了64个字符的限制，应该返回验证错误",
    "campusNum": "20246666666"
}
```
**预期响应**:
```json
{
    "code": 400,
    "msg": "realName: 真实姓名长度不能超过64位; ",
    "data": null
}
```

### 9. 验证失败 - 必填字段为空（用户名）
```json
POST /auth/register
{
    "username": "",
    "password": "Test123456",
    "realName": "郑十一",
    "campusNum": "20247777777"
}
```
**预期响应**:
```json
{
    "code": 400,
    "msg": "username: 用户名不能为空; ",
    "data": null
}
```

### 10. 验证失败 - 缺少必填字段
```json
POST /auth/register
{
    "password": "Test123456",
    "realName": "王十二",
    "campusNum": "20248888888"
}
```
**预期响应**:
```json
{
    "code": 400,
    "msg": "username: 用户名不能为空; ",
    "data": null
}
```

### 11. 业务错误 - 用户名已存在
首先注册一个用户，然后使用相同的用户名再次注册：
```json
POST /auth/register
{
    "username": "duplicateuser",
    "password": "Test123456",
    "realName": "李十三",
    "campusNum": "20249999999"
}
```
**预期响应**:
```json
{
    "code": 1004,
    "msg": "用户名已存在",
    "data": null
}
```

### 12. 业务错误 - 学工号已存在
首先注册一个用户，然后使用相同的学工号再次注册：
```json
POST /auth/register
{
    "username": "differentuser",
    "password": "Test123456",
    "realName": "陈十四",
    "campusNum": "20240000000"
}
```
**预期响应**:
```json
{
    "code": 1005,
    "msg": "学工号已存在",
    "data": null
}
}
```

## 字段验证规则

1. **username** (用户名):
   - 4-20位字符
   - 只能包含字母、数字和下划线
   - 不能为空
   - 必须唯一

2. **password** (密码):
   - 长度大于8位
   - 必须包含字母和数字
   - 不能为空

3. **realName** (真实姓名):
   - 长度不超过64位
   - 不能为空

4. **campusNum** (学工号):
   - 必须是11位数字
   - 不能为空
   - 必须唯一

## 测试命令示例

### 使用 curl:
```bash
# 成功注册
curl -X POST http://your-server:port/auth/register \
  -H "Content-Type: application/json" \
  -d '{
    "username": "testuser202412",
    "password": "Test123456",
    "realName": "张三",
    "campusNum": "20241234567"
  }'

# 验证失败 - 用户名太短
curl -X POST http://your-server:port/auth/register \
  -H "Content-Type: application/json" \
  -d '{
    "username": "ab",
    "password": "Test123456",
    "realName": "王五",
    "campusNum": "20241111111"
  }'
```

### 使用 Python:
```python
import requests
import json

url = "http://your-server:port/auth/register"
headers = {"Content-Type": "application/json"}

# 成功注册
data = {
    "username": "testuser202412",
    "password": "Test123456",
    "realName": "张三",
    "campusNum": "20241234567"
}

response = requests.post(url, headers=headers, data=json.dumps(data))
print(f"Status Code: {response.status_code}")
print(f"Response: {response.json()}")
```

## 注意事项

1. 所有测试用例都应该返回 HTTP 200 状态码，但业务错误会有不同的 code 值
2. 验证失败会返回 code 400，并带有详细的字段错误信息
3. 用户名和学工号必须唯一，不能重复注册
4. 密码会被自动加密存储
5. 默认身份类型为学生（identityType=1）
6. 默认状态为正常（status=1）
7. 注册成功后会返回用户ID

## 错误码说明

- **200**: 操作成功
- **400**: 参数验证失败
- **1004**: 用户名已存在
- **1005**: 学工号已存在
- **500**: 系统内部错误（现在会包含详细的错误信息）