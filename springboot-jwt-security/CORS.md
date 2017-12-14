跨域

前面我们初步做出了一个可以实现受保护的 REST API，但是我们没有涉及一个前端领域很重要的问题，那就是跨域请求（ cross-origin HTTP request ）。先来回顾一些背景知识：

跨域请求

定义：当我们从本身站点请求不同域名或端口的服务所提供的资源时，就会发起跨域请求。
例如最常见的我们很多的 css 样式文件是会链接到某个公共 CDN 服务器上，而不是在本身的服务器上，这其实就是典型的一个跨域请求。但浏览器由于安全原因限制了在脚本（ script ）中发起的跨域 HTTP 请求。也就是说 XMLHttpRequest 和 Fetch 等是遵循“同源规则”的，即只能访问自己服务器的指定端口的资源（同一服务器不同端口也会视为跨域）。但这种限制在今天，我们的应用需要访问多种外部 API 或 资源的时候就不能满足开发者的需求了，因此就产生了若干对于跨域的解决方案，JSONP 是其中一种，但在今天来看主流的更彻底的解决方案是 CORS （ Cross-Origin Resource Sharing ）。

跨域资源共享 （ CORS ）

这种机制将跨域的访问控制权交给服务器，这样可以保证安全的跨域数据传输。现代浏览器一般会将 CORS 的支持封装在 HTTP API 之中（ 比如 XMLHttpRequest 和 Fetch ），这样可以有效控制使用跨域请求的风险，因为你绕不过去，总得要使用 API 吧。

概括来说，这个机制是增加一系列的 HTTP 头来让服务器可以描述哪些源是允许使用浏览器来访问资源的。而且对于简单的请求和复杂请求，处理机制是不一样的。

简单请求仅允许三个 HTTP 方法：GET，POST 以及 HEAD，另外只能支持若干 header 参数：Accept ， Accept-Language ， Content-Language ， Content-Type （值只能是 application/x-www-form-urlencoded、multipart/form-data 和 text/plain）， DPR ， Downlink ， Save-Data ， Viewport-Width 和 Width。

对于简单请求来说，比如下面这样一个简单的GET请求：从 http://me.domain 发起到 http://another.domain/data/blablabla 的资源请求

GET /data/blablabla/ HTTP/1.1
// 请求的域名
Host: another.domain
...//省略其它部分，重点是下面这句，说明了发起请求者的来源
Origin: http://me.domain
应用了 CORS 的对方服务器返回的响应应该像下面这个样子，当然这里 Access-Control-Allow-Origin: * 中的 * 表示任何网站都可以访问该资源，如果要限制只能从 me.domain 访问，那么需要改成 Access-Control-Allow-Origin: http://me.domain

HTTP/1.1 200 OK
...//省略其它部分
Access-Control-Allow-Origin: *
...//省略其它部分
Content-Type: application/json
那么对于复杂请求怎么办呢？这需要一次预检请求和一次实际的请求，也就是说需要两次和对方服务器的请求/响应。预检请求是以 OPTION 方法进行的，因为 OPTION 方法不会改变任何资源，所以这个预检请求是安全的，它的职责在于发送实际请求将会使用的 HTTP 方法以及将要发送的 HEADER 中将携带哪些内容，这样对方服务器可以根据预检请求的信息决定是否接受。

// 预检请求
OPTIONS /resources/post/ HTTP/1.1
Host: another.domain
...// 省略其它部分
Origin: http://me.domain
Access-Control-Request-Method: POST
Access-Control-Request-Headers: Content-Type
服务器对预检请求的响应如下：

HTTP/1.1 200 OK
// 省略其它部分
Access-Control-Allow-Origin: http://me.domain
Access-Control-Allow-Methods: POST, GET, OPTIONS
Access-Control-Allow-Headers: Content-Type
Access-Control-Max-Age: 86400
// 省略其它部分
Content-Type: text/plain
接下来的正式请求就和上面的简单请求差不多了，就不赘述了。

在 Spring Boot 中如何启用 CORS

啰嗦了这么多，终于进入正题，但我一直觉得不能光知其然而不知其所以然，所以各位就忍了吧。加入 CORS 的支持在 Spring Boot 中简单到不忍直视，添加一个配置类即可：

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {
    @Bean
    public FilterRegistrationBean corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        // 设置你要允许的网站域名，如果全允许则设为 *
        config.addAllowedOrigin("http://localhost:4200");
        // 如果要限制 HEADER 或 METHOD 请自行更改
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        // 这个顺序很重要哦，为避免麻烦请设置在最前
        bean.setOrder(0);
        return bean;
    }
}

如果我们使用 POSTMAN 访问一下 API，会发现得到一个 Invalid CORS request 的响应，因为我们的 API 只授权给了 localhost:4200

http://localhost:8090/auth POST
{
  "username": "test",
  "password": "pwd"
}

Invalid CORS request

当然，如果我们使用 CURL 的话是可以访问的，这是因为 CURL 不是浏览器