# 项目骨架（React + Spring Cloud）

## 1. 项目简介
本项目采用前后端分离架构：

- 前端：`frontend/`，基于 React（建议使用 Vite）
- 后端：`backend/`，基于 Spring Cloud 的父工程，统一管理网关、注册中心与业务微服务
- 基础设施：`infra/`，用于本地开发依赖（如 docker-compose、中间件、可选网关/注册中心辅助配置）

## 2. 本地启动顺序
推荐按以下顺序启动，降低依赖失败概率：

1. 启动基础设施（如 `infra/` 下的 Docker 服务）
2. 启动注册中心（Eureka）
3. 启动网关（Gateway）
4. 启动后端业务微服务（按依赖顺序）
5. 启动前端应用（React）

## 3. 端口规划（建议）
- `frontend`：`5173`
- `gateway`：`8080`
- `eureka`：`8761`

可按实际模块扩展，例如：
- `user-service`：`9001`
- `order-service`：`9002`

## 4. 各模块职责说明
- `frontend/`：
  - React 前端工程
  - 负责页面渲染、路由与调用网关 API
- `backend/`：
  - Spring Cloud 父工程（统一依赖与版本管理）
  - 包含注册中心、网关及各业务微服务子模块
- `infra/`：
  - 本地运行环境编排与依赖声明（如 MySQL、Redis、MQ 等）
  - 可维护 `docker-compose.yml`、初始化脚本与本地开发辅助配置

---
后续可在以上目录中分别初始化具体项目模板与模块代码。
