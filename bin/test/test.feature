@test
Feature:

  Scenario: 测试
    When 设置项目名称后缀为:这是一个测试项目
    When 调用GET接口,url:"http://baidu.com/"
    When 调用GET接口,url:"https://tieba.baidu.com/"
    When 调用POST接口,url:"http://www.example.com/",json:"'code':200"
    Then 调用POST接口,url:"http://www.example.com/",json:"'code':200"