####  index和type  的增删
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
3. 删除index 
4. 删除Type 

 想要删除type有两种选择： 
 1.重新设置index。 
 2.删除type下的所有数据。
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

### ES实现CURD    

1. 增加数据  
2. 批量插入数据
3. 删除数据
4. 更新数据
5. 查询 
5.1 基本查询 
5.2 高级查询 

### ES高级数据查询   
1. 聚合查询
2. 建议查询
3. 。。。

### ES配置和主从配置
1. 各个配置的含义
2. 实现主从配置  

### Java代码访问ES

1. 实现CRUD 
2. 实现高级分析