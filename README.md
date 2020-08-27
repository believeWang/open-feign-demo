# open-feign-demo
demo open feign with hytrix retryer


開啟upper-case-stragedy 再開啟open-feign-demo server  開啟時會自動開始跑  打upper-case-stragedy 可以觀察兩件事情

1. 當upper-case-stragedy 未開啟時，get會執行較長時間，因為會嘗試retry
2. upper-case-stragedy的get 固定回傳bad request  所以 hystrix 判定伺服器有誤 打一百次  大概從60~70次之後就會被斷開了
