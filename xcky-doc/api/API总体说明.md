# API文档总体说明


> 访问要求

- 使用restful服务接口

  ​

- API路径：
  `var restPath="http://localhost:8022/xcky"`


- 请求头：

  ```json
  所有json请求
  Content-Type:application/json; charset=UTF-8
  token:token密匙

  所有文件上传请求
  Content-Type:multipart/form-data; boundary=----WebKitFormBoundary1H3k9h9lxzAbSaxO
  token:token密匙
  ```


- 响应体：

  ```json
  {
      "flag": "请求是否成功（0-失败,1-成功）",
      "msg": "请求结果描述",
      "totalCount": "条数",
      "data": "返回数据"
  }
  ```

