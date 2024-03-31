# Minis

## 手把手带你写一个MiniSpring

### 08｜整合IoC和MVC：如何在Web环境中启动IoC容器？

当 Servlet 服务器如 Tomcat 启动的时候，要遵守下面的时序。

- 在启动 Web 项目时，Tomcat 会读取 web.xml 中的 context-param 节点，获取这个 Web 应用的全局参数。

- Tomcat 创建一个 ServletContext 实例，是全局有效的。

- 将 context-param 的参数转换为键值对，存储在 ServletContext 里。

- 创建 listener 中定义的监听类的实例，按照规定 Listener 要继承自 ServletContextListener。

- 监听器初始化方法是 contextInitialized(ServletContextEvent event)。

- 初始化方法中可以通过 event.getServletContext().getInitParameter(“name”) 方法获得上下文环境中的键值对。

- 当 Tomcat 完成启动，也就是 contextInitialized 方法完成后，再对 Filter 过滤器进行初始化。

- servlet 初始化：有一个参数 load-on-startup，它为正数的值越小优先级越高，会自动启动，如果为负数或未指定这个参数，会在 servlet 被调用时再进行初始化。

- init-param 是一个 servlet 整个范围之内有效的参数，在 servlet 类的 init() 方法中通过 this.getInitParameter(″param1″) 方法获得。

Spring中有父子容器的概念。子容器：MVC容器，父容器：Spring容器。子可以访问父，反过来不行，这是由Spring的体系结构决定的，子容器继承父容器，所以子容器是知道父容器的.
所以也就能得到父容器的引用，进而得到父容器中的bean。但是父容器是无法知道子容器的，所以也就无法直接获取子容器中的bean，但是可以通过getBeanFactory来得到子容器，
从而获取到子容器中的bean，但java的三层模型，controller--->service--->dao，controller注入service对象是正常的，service注入controller有点奇怪，一般不这么干。