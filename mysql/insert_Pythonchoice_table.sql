use quiztest;

INSERT INTO choice (question_id, is_answer, choice_detail)
VALUES 
	(21, 0, 'Lifecycle management'),
	(21, 0, 'Communication support'),
	(21, 0, 'Multithreading support'),
	(21, 1, 'Implicit security'),

	(22, 0, 'part of Web server that provides network services depends on request and response are sent'),
	(22, 0, 'contains and manages servlets through their life cycle'),
	(22, 0, 'client/user can request a static WebPages from the server'),
	(22, 1, 'client/user can request a dynamic WebPages from the server'),

	(23, 0, 'A session is an object which is used by a servlet'),
	(23, 0, 'is used to track user interaction with a web application across multiple HTTP requests'),
	(23, 1, 'is used to track user interaction with a web application across multiple HTTP responses'),
	(23, 0, 'maintain session between web client and web server'),

	(24, 0, 'Remove a particular attribute − You can call public void removeAttribute(String name) method to delete the value associated with a particular key'),
	(24, 0, 'Setting Session timeout − You can call public void setMaxInactiveInterval(int interval) method to set the timeout for a session individually'),
	(24, 0, 'Log the user out − The servers that support servlets 2.4, you can call logout to log the client out of the Web server and invalidate all sessions belonging to all the users'),
	(24, 1, 'web.xml Configuration − If you are using Maven, apart from the above mentioned methods, you can configure session time out in web.xml file as follows'),

	(25, 0, 'Hidden Form Fields - A web server can send a hidden HTML form field along with a unique session ID'),
	(25, 0, 'Cookies - A webserver can assign a unique session ID as a cookie to each web client and for subsequent requests from the client they can be recognized using the received cookie'),
	(25, 0, 'URL Rewriting - You can append some extra data on the end of each URL that identifies the session, and the server can associate that session identifier with data it has stored about that session.'),
	(25, 1, 'Caching - storing copies of files in a cache, or temporary storage location, so that they can be accessed more quickly'),

	(26, 0, 'Log events'),
	(26, 1, 'Get and Retrieve attributes'),
	(26, 0, 'Set and Store attributes'),
	(26, 0, 'Obtain URL references to resources'),

	(27, 1, 'Relative URL can be called when Servlet Request is used and Relative URL is not used when using Servlet Context'),
	(27, 0, 'Relative URL can be called when Servlet Request is not used and Relative URL is used when using Servlet Context'),
	(27, 0, 'Relative URL can be called when Servlet Request is used and Relative URL is not used when using Servlet Mapping'),
	(27, 0, 'Relative URL can be called when Servlet Request is not used and Relative URL is used when using Servlet Mapping'),

	(28, 0, 'First request is made'),
	(28, 0, 'Auto loading and Server starts up'),
	(28, 0, 'There is a single instance that answers all requests concurrently which  saves memory'),
	(28, 1, 'Administrator automatically loads'),

	(29, 1, 'Servlet interface should be implemented by all servlets'),
	(29, 0, 'Functional interface should be implemented by all servlets.'),
	(29, 0, 'Runnable interface should be implemented by all servlets.'),
	(29, 0, 'Controller interface should be implemented by all servlets.'),

	(30, 0, 'Initialized, Loaded, Destroy, Unloaded'),
	(30, 1, 'Loaded, Initialized, Destroy, Unloaded'),
	(30, 0, 'Loaded, Initialized, Unloaded, Destroy'),
	(30, 0, 'Initialized, Loaded, Unloaded, Destroy'),

	(31, 0, 'Security check'),
	(31, 0, 'Modifying the request or response'),
	(31, 1, 'Data collection'),
	(31, 0, 'Logging and auditing'),

	(32, 0, 'JSP supports HTTP protocol'),
	(32, 0, 'JSP mainly used for presentation'),
	(32, 0, 'servlet can support any protocol'),
	(32, 1, 'servlet can support only HTML protocol'),

	(33, 1, 'A scriptlet contains any language statements, variables, expressions that can be valid in the page scripting language.'),
	(33, 0, 'A scriptlet contains any language statements, variables, expressions that can be invalidated in the page scripting language.'),
	(33, 0, 'A scriptlet contains any language statements, variables, expressions that can be valid in the servlet scripting language.'),
	(33, 0, 'A scriptlet contains any language statements, variables, expressions that can be invalidated in the pservletage scripting language.'),

	(34, 0, 'Containers hold set of objects. A server can provide service to the client and it contains one or more containers such as EJBs container.'),
	(34, 0, 'Containers hold set of objects. A server can provide service to the client and it contains one or more containers such as Servlet container.'),
	(34, 1, 'Containers hold set of objects. A server can provide service to the client and it contains one or more containers such as Java container.'),
	(34, 0, 'Containers hold set of objects. A server can provide service to the client and it contains one or more containers such as JSP container.'),

	(35, 0, 'ServletConfig provides information about configuration of a servlet which is defined inside the web.xml file'),
	(35, 0, 'ServletConfig is a specific object for each servlet.'),
	(35, 0, 'ServletContext is an application specific object and it is shared by all servlet.'),
	(35, 1, 'ServletContext belongs to one application in multiple JVMs.'),

	(36, 1, 'Servlets are used for server side config and it keeps on server. But, Applets are used for client side coding and it runs on client browsers.'),
	(36, 0, 'Servlets are used for client side config and it keeps on client. But, Applets are used for server side coding and it runs on servers.'),
	(36, 0, 'Servlets are used for server side config and it keeps on client. But, Applets are used for client side coding and it runs on servers.'),
	(36, 0, 'Servlets are used for client side config and it keeps on server. But, Applets are used for server side coding and it runs on client browsers.'),

	(37, 1, 'HttpServlet implements from GenericServlet'),
	(37, 0, 'HttpServlet inherits the properties of Genericservlet'),
	(37, 0, 'HttpServlet defines a HTTP protocol servlet'),
	(37, 0, 'GenericServlet defines a generic, protocol-independent servlet'),

	(38, 0, 'Servlet mapping maps URL patterns with the servlets.'),
	(38, 1, 'If there is a response from the server, servlet container decides on which application it needs to map.'),
	(38, 0, 'It is located in WEB-INF directory of the web application.'),
	(38, 0, 'servlet-mapping has two child tags, url-pattern and servlet-name'),

	(39, 0, 'Cannot be run in an individual process'),
	(39, 0, 'Servlet stays in the memory while requests'),
	(39, 0, 'For every CGI request, you must load and start a CGI program'),
	(39, 1, 'web.xml performance gains'),

	(40, 0, 'Servlets are used to process and store data submitted by HTML form.'),
	(40, 1, 'Servlets are used to process and store static content.'),
	(40, 0, 'Servlets are used to handle multiple request concurrently.'),
	(40, 0, 'Servlets are used to manage state information on top of stateless HTTP.');