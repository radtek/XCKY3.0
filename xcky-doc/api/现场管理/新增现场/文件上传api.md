# 文件上传API文档

> API接口列表

1. 文件上传api

   ​



> 文件上传api

- API路径：
  `http://localhost:58820/fdfs/api/file/upload`


- 请求类型：
  `HTTP POST`


- 请求头：

  ```
  Content-Type:multipart/form-data
  ```


- 请求体：

  ```
  ------WebKitFormBoundaryawjUz3uXaUBn2gNp
  Content-Disposition: form-data; name="file"; filename="QQ截图20170104153819.jpg"
  Content-Type: image/jpeg


  ------WebKitFormBoundaryawjUz3uXaUBn2gNp--
  ```


- 响应体：

  ```json
  {
    "message": "成功",
    "flag": "1",
    "data": {
      "fileNameLocal": "QQ20161214100824.jpg",
      "fileNameRemote": "M00/00/00/rBAAcFhQ28-ADrTqAAB4j3IO8vE475.jpg",
      "isImage": true
    }
  }
  说明：
  原图："http://172.16.0.112/M00/00/00/rBAAcFhQ28-ADrTqAAB4j3IO8vE475.jpg"
  缩略图："http://172.16.0.112/M00/00/00/rBAAcFhQ28-ADrTqAAB4j3IO8vE475_thumb.jpg"
  预览图："http://172.16.0.112/M00/00/00/rBAAcFhQ28-ADrTqAAB4j3IO8vE475_preview.jpg"
  ```

