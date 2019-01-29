#### 新建index和type  
1.  创建index（db）
``` bash

put  /fwdatabase

```

2. 创建type (tb)

```bash
put   /fwdatabase/_mapping/order
{
  "properties": {
    "orderId": {
      "type": "keyword"
    },
    "shortTime": {
      "type": "keyword"
    },
    "amount": {
      "type": "double"
    },
    "desc": {
      "type": "text"
    }
  }
}

```

**报错：**
```cte
ClusterBlockException[blocked by: [FORBIDDEN/12/index read-only / allow delete (api)];]
```   
**解决方法：**
```cte
PUT /fwdatabase/_settings
{ 
"index.blocks.read_only_allow_delete": null 
}
```

**遇到问题：**  

```cte
flood stage disk watermark [95%] exceeded on [m-1Ddl_kSZ-X5jDg0R6EKA][m-1Ddl_][D:\elasticsearch-6.5.4\data\nodes\0] free: 4gb[3.7%], all indices on this node will be marked read-only
```
