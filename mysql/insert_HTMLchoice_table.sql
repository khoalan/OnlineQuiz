use quiztest;

INSERT INTO choice (question_id, is_answer, choice_detail)
VALUES 
	(1, 0, 'Hypertext Machine language'),
	(1, 0, 'Hypertext and links markup language.'),
	(1, 1, 'Hypertext Markup Language'),
	(1, 0, 'Hightext machine language'),

	(2, 0, '</DOCTYPE HTML>'),
	(2, 0, '</DOCTYPE>'),
	(2, 1, '<!/DOCTYPE HTML>'),
	(2, 0, '</DOCTYPE Html>'),

	(3, 0, '<p>'),
	(3, 0, '<i>'),
	(3, 0, '<li>'),
	(3, 1, '<b>'),

	(4, 0, '<ui>'),
	(4, 0, '<i>'),
	(4, 0, '<em>'),
	(4, 1, '<ul>'),

	(5, 0, '.'),
	(5, 1, '/'),
	(5, 0, '//'),
	(5, 0, '!'),

	(6, 0, 'Boolean − true and false'),
	(6, 1, 'Double - floating point'),
	(6, 0, 'String − with single and double quotes'),
	(6, 0, 'Integer − as in Java'),

	(7, 0, 'Boolean − true and false'),
	(7, 1, 'Double - floating point'),
	(7, 0, 'String − with single and double quotes'),
	(7, 0, 'Integer − as in Java'),

	(8, 0, 'jsp:useBean - The jsp:useBean action tag is used to locate or instantiate a bean class'),
	(8, 1, 'jsp:setBean - The jsp:setBean action tag is set a new bean class'),
	(8, 0, 'jsp:setProperty - The jsp:setProperty action tag sets a property value or values in a bean using the setter method'),
	(8, 0, 'jsp:getProperty - The jsp:getProperty action tag returns the value of the property'),

	(9, 0, 'JSP pages are used for view purposes'),
	(9, 0, 'all the business logic should be in servlet or model'),
	(9, 0, 'We should pass parameters to the JSP page through attributes'),
	(9, 1, 'then use them to create the HTML request in the JSP page'),

	(10, 1, 'Main Tags: Provides support for iteration, conditional logic, catch the exception, URL, forward or redirect response, and more'),
	(10, 0, 'Formatting and Localization Tags: Provided for the formatting of Dates, Numbers, and i18n support through resource bundles and locales'),
	(10, 0, 'SQL Tags: Provide support for interaction with relational databases such as Oracle, MySql, and more'),
	(10, 0, 'XML Tags: Used to work with XML documents such as parsing XML, transforming XML data and XPath expression evaluation'),

	(11, 0, 'Complilation, Translation, ClassLoading, Instatiation, Initialization, Request Processing, Destroy'),
	(11, 1, 'Translation, Complilation, ClassLoading, Instatiation, Initialization, Request Processing, Destroy'),
	(11, 0, 'Translation, Complilation, ClassLoading, Initialization, Instatiation, Request Processing, Destroy'),
	(11, 0, 'Translation, Complilation, , Instatiation, Initialization, ClassLoading, Request Processing, Destroy'),

	(12, 1, 'HTML Comments and JSP Comments'),
	(12, 0, 'HTML Comments and CSS Comments'),
	(12, 0, 'CSS Comments and JSP Comments'),
	(12, 0, 'JSP Comments and Servlet Comments'),

	(13, 0, 'Happens in the browser'),
	(13, 1, 'Requies a network trip to the server'),
	(13, 0, 'Instantaneous feedback may be provider'),
	(13, 0, 'Credit card information is a typical example of JavaScript client-side validation'),

	(14, 0, 'Happens in the server'),
	(14, 0, 'client is supposed to wait for a response from the server before displaying any success or error message to the user'),
	(14, 1, 'In the case of validation failure, no extra network trip is needed to resend the form to fill out the form with the correct data by the client.'),
	(14, 0, 'the server can’t execute its validation until it’s received an HTTP request'),

	(15, 0, 'It eliminates the need for the scriptlet tag'),
	(15, 0, 'Separation of business logic from the JSP page'),
	(15, 0, 'Reusability of the JSP page'),
	(15, 1, 'Deployment Descriptor Configuration for TLD'),

	(16, 0, 'By errorPage attribute of page directive'),
	(16, 0, 'By isErrorPage attribute of page directive'),
	(16, 0, 'By <error-page> element in web.xml file'),
	(16, 1, 'By <is-error-page> element in web.xml file'),

	(17, 1, 'JSP is used for controller in the Model View Controller pattern'),
	(17, 0, 'it means it plays the role of the view.'),
	(17, 0, 'The controller calls the model and the business classes, which in turn get the data'),
	(17, 0, 'and this data is then presented to the JSP for rendering on to the client'),

	(18, 0, 'JavaBeans and taglib were introduced for reusability'),
	(18, 0, 'JavaBeans are good for storing information and state'),
	(18, 0, 'Taglibs are for generating presentation elements'),
	(18, 1, 'Use action tags to implement actions and JavaBeans to present information'),

	(19, 0, 'public static void setIntHeader(String header, int header value)'),
	(19, 0, 'public void setIntHeader(Boolean header, int header value)'),
	(19, 1, 'public void setIntHeader(String header, int header value)'),
	(19, 0, 'public void setIntHeader(Char header, int header value)'),

	(20, 0, 'The JSP comment is called hide comment'),
	(20, 0, 'the HTML comment is called the output comment'),
	(20, 0, 'JSP comment will not be shown in the case if a user views the source of the page'),
	(20, 1, 'HTML comments will also not be displayed')