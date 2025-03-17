# Starter backend

嗨， 这里是Starter项目模板生成器的后端， 后端主要就是负责生成zip压缩文件

# 配置

修改`resources/config/config.json`内的`frontend`可以设置前端URL, 但是实际上这个属性设置之后并不会对程序本身有什么影响
只不过是在访问`/`的时候会将配置后的前端URL显示出来

# 构建和部署

你可以用下面的命令来构建出一个可执行的jar

`./gradlew :ronebot-starter:starter-backend:buildFatJar`

或者使用下面的命令来一键部署到koyeb

[![Deploy to Koyeb](https://www.koyeb.com/static/images/deploy/button.svg)](https://app.koyeb.com/deploy?name=ronebot&repository=RTAkland%2FROneBot&branch=main&builder=dockerfile&dockerfile=.%2Fronebot-starter%2Fstarter-backend%2FDockerfile&instance_type=free&instances_min=0&ports=9099%3Bhttp%3B%2F&hc_protocol%5B9099%5D=tcp&hc_grace_period%5B9099%5D=5&hc_interval%5B9099%5D=30&hc_restart_limit%5B9099%5D=3&hc_timeout%5B9099%5D=5&hc_path%5B9099%5D=%2F&hc_method%5B9099%5D=get)