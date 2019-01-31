### ES  
Elastic 会索引所有字段，经过处理后写入一个反向索引（Inverted Index）。查找数据的时候，直接查找该索引。

所以，Elastic 数据管理的顶层单位就叫做 Index（索引）。它是单个数据库的同义词。每个 Index （即数据库）的名字必须是小写。

Elastic 6.x 版只允许每个 Index 包含一个 Type，7.x 版将会彻底移除 Type

#### ES系统时间  

1. 查询所有的Index  

    ```json   
    
    GET http://localhost:9200/_cat/indices?v  
    
    ```  

2. 查询Index所包含的 Type  

    ```json
    
    GET localhost:9200/_mapping?pretty=true  
    
    ```  
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
```json 
delete /fwdatabase
```
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

    ```json 
    POST  /fwdatabase/order
    {
     "orderId":"1111",
     "name":"user",
     "amount":12.09,
     "desc":"测试"  
    }
    ```   
    服务器返回JSON 对象，会给出 Index、Type、Id、Version 等信息
2. 批量插入数据

    ```json
    POST /fwdatabase/order/_bulk
    { "index": { "_id": 5 }}
    {"orderId":"1111", "name":"user", "amount":12.09, "desc":"测试"}
    { "index": { "_id":8 }}
    {"orderId":"1112311", "name":"user", "amount":112.09, "desc":"测试1231"}
    ```
    ```json

    { "index": {}}
    {"orderId":"1111", "name":"user", "amount":12.09, "desc":"测试"}
    { "index": {}}
    {"orderId":"1112311", "name":"user", "amount":112.09, "desc":"测试1231"}

   ```    
3. 更新数据     

    ```json
    POST fwdatabase/order/lCYuo2gBn1FEHZKM5Wsw 
    {
     "orderId":"111123121",
     "name":"user",
     "amount":12122.76,
     "desc":"测试"  
    }
    ```
4. 批量更新数据     

    ```json
     POST /fwdatabase/order/_bulk
     { "index": { "_id": 5 }}
     {"orderId":"1111", "name":"user", "amount":12.09, "desc":"测试"}
     { "index": { "_id":8 }}
     {"orderId":"1112311", "name":"user", "amount":112.09, "desc":"测试1231"}
    ```
4. 删除数据   
   ```json
   DELETE  /fwdatabase/order/lCYuo2gBn1FEHZKM5Wsw
   ```

5. 批量删除数据    

6. 使用Search Lite API
7. （DSL）查询 
  - 基本查询    
    1. 查询所有   
    ```json
     GET /fwdatabase/order/_search
    ```   
    
    2. 按条件匹配查询    
    
    ``` json
    POST /fwdatabase/order/_search
    {
        "query": {
            "match": {//包含
                "desc": "测试"
            }
        }
    }
    ```   
    精确匹配： 
    ```json
     POST /fwdatabase/order/_search
    {
        "query": {
            "term": {//term精确
                "amount": 12.09
            }
        }
    }

    ```  
    使用非评分模式(返回结果中没有评分的信息)：  
    
    ```json
     POST /fwdatabase/order/_search
    {
        "query" : {
            "constant_score" : { 
                "filter" : {
                    "term" : { 
                        "amount" : 12.09
                    }
                }
            }
        }
    }
    ```
    
    3. 分页查询  
    
    ```json
    POST /fwdatabase/order/_search
     {
        "query": {
            "match": {
                "desc": "测试"
            }
        }, 
        "from": 1,
        "size": 1
     }
    ```
    
    返回信息：  
    ```json
    {
        "took": 14,//耗时 ms
        "timed_out": false,//是否超时
        "_shards": { //分片信息
            "total": 5, //分片个数
            "successful": 5, //成功启用分片个数
            "skipped": 0,
            "failed": 0
        },
        "hits": {
            "total": 7,//总共命中几条数据
            "max_score": 1.219939, //最高得分，[相关文档](https://www.elastic.co/guide/cn/elasticsearch/guide/cn/practical-scoring-function.html)
            "hits": [
                {
                    "_index": "fwdatabase",
                    "_type": "order",
                    "_id": "1",
                    "_score": 1.219939,//_score字段，表示匹配的程序，默认是按照这个字段降序排列
                    "_source": {
                        "orderId": "1111",
                        "name": "user",
                        "amount": 12.09,
                        "desc": "测试"
                    }
                } 
            ]
        }
    }
    ```
 
6.2 高级查询 

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