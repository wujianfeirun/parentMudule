**1 spring boot传参方式，**

@RequestParam("name")String name     url参数 及 x-www的key/value

@PathVariable("var") String var      /Xlogin/{var}方式

@RequestBody String postJson         json

@RequestBody和@RequestParam不能混用。

**2 @RequestAttribute**



**3 POST  GET  PUT  DELETE**
使用从参数传递方面来说没有太大的区别，主要是用业务来区分，
GET：一般用于查询数据，不办函数据的更新以及插入操作。由于明文传输的关系，我们一般用来获取一些无关用户的信息。

POST：一般用于数据的插入操作，也是使用最多的传输方式，但是在H5调用时会有跨域的问题，一般使用JSONP来解决。

PUT：我们使用PUT方式来对数据进行更新操作。

DELETE：用于数据删除，注意在数据库内是逻辑删除（改变数据状态，用户不再查询得到，但还保留在数据库内）还是物理删除（真删了）。

**4 @RequestMapping 与 @GetMapping**
两者相同，同理 @PostMapping。。。
    @RequestMapping(value = "/url/get",method = RequestMethod.GET)
    @GetMapping(value = "/url/get")