# NanoKit
[![CI Status](http://img.shields.io/travis/maxep/NanoKit.svg?style=flat)](https://travis-ci.org/maxep/NanoKit)
[![npm](https://img.shields.io/npm/l/express.svg?style=flat)](http://opensource.org/licenses/MIT)
[![Release](http://img.shields.io/github/release/maxep/NanoKit.svg?style=flat)](https://github.com/maxep/NanoKit/releases)
[![Issues](http://img.shields.io/github/issues/maxep/NanoKit.svg?style=flat)](https://github.com/maxep/NanoKit/issues)

A light Web Service client framework targeting Android platform.

##_Note_
_NanoKit is initially a fork of [nano](https://github.com/bulldog2011/nano)._

_[Nano](https://github.com/bulldog2011/nano) (and related projects: [mxjc](https://github.com/maxep/mxjc), [mwsc](https://github.com/maxep/mwsc) & [pico](https://github.com/maxep/pico)) has been developed by [bulldog2011](http://bulldog2011.github.com) but stayed as is from 2013. As it is very well designed and implemented, I decided to fork it and upgrade it._

##Feature Highlight
1. Support WSDL driven development, [code generator](https://github.com/maxep/max-ws) tool is provided to auto-genearte strongly typed proxy from WSDL. 
2. Support SOAP 1.1/1.2 and XML based web service. 
3. Support automatic SOAP/XML to Java object binding, performance is comparable to Android native XML parser.
4. Built on popular and mature [loopj async http client](https://github.com/loopj/android-async-http) library for Android.
5. Has been verified with industrial grade Web Service like Amazon ECommerce Web Serivce and eBay Finding/Shopping/Trading Web Service. 
6. Support asynchronous service invocation, flexible HTTP/SOAP header setting, timeout setting, encoding setting, logging, etc.
7. Light-weight, the library jar is less than 150K, no external dependencies on Android platform.
8. Besides Web Service, can also be used as a standalone XML and JSON binding framework.

## The Big Picture
![The Big Picture](http://bulldog2011.github.com/images/nano/big_picture.png)

##How to Use
You have a few options:

1. Direct jar reference  
Download latest [0.7.1 release](https://github.com/maxep/mvn-repo/tree/releases/com/leansoft/nano-kit/0.7.1)  

2. Include the whole source of Nano into your project

3. Maven reference

``` xml
	<dependency>
	  <groupId>com.leansoft</groupId>
	  <artifactId>nano-kit</artifactId>
	  <version>0.7.1</version>
	</dependency>
	
	<repository>
	  <id>maxep-releases</id>
	  <url>https://raw.github.com/maxep/mvn-repo/releases</url>
	</repository>
```
4. Gradle reference
```
	dependencies {
		compile 'com.leansoft:nano-kit:0.7.1-SNAPSHOT'
	}

	repositories {
		maven {
			url "https://raw.github.com/maxep/mvn-repo/snapshots"
		}
	}
``
After including Nano into your project, please make sure to add following user permissions in the `AndroidManifest.xml` file for network access:

``` xml
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
```

##WSDL Driven Development Flow
1. Generate Java proxy from WSDL
2. Create new Android project, add Nano runtime and generated proxy into your project
3. Implement appliction logic and UI, call proxy to invoke web service as needed.

##Example Usage
After the service proxy is generated from wsdl, service invocation through Nano runtime is extremely simple:

``` java

	// Get shared client
	NumberConversionSoapType_SOAPClient client = NumberConversionServiceClient.getSharedClient();
	client.setDebug(true); // enable soap message logging
	
	// build request
	NumberToWords request = new NumberToWords();
	try {
		String number = ((EditText)findViewById(R.id.numerInputText)).getText().toString();
		request.ubiNum = new BigInteger(number);
	} catch (NumberFormatException ex) {
		Toast.makeText(MainActivity.this, "Invalid integer number", Toast.LENGTH_LONG).show();
		return;
	}
	
	client.numberToWords(request, new SOAPServiceCallback<NumberToWordsResponse>() {

		@Override
		public void onSuccess(NumberToWordsResponse responseObject) { // success
			Toast.makeText(MainActivity.this, responseObject.numberToWordsResult, Toast.LENGTH_LONG).show();
		}

		@Override
		public void onFailure(Throwable error, String errorMessage) { // http or parsing error
			Toast.makeText(MainActivity.this, errorMessage, Toast.LENGTH_LONG).show();
		}

		@Override
		public void onSOAPFault(Object soapFault) { // soap fault
			Fault fault = (Fault)soapFault;
			Toast.makeText(MainActivity.this, fault.faultstring, Toast.LENGTH_LONG).show();
		}
		
	});

```

## Web Service Sample List
All samples are in the [sample](sample) folder, following samples are included:

* NumberConverter - sample using [Number Conversion Service](http://www.dataaccess.com/webservicesserver/numberconversion.wso) SOAP web service from [Data Access Worldwide](http://www.dataaccess.com/).
* USZipValidator - sample using [US Zip Validation Service](http://www.webservicemart.com/uszip.asmx) SOAP Web service from [WebServiceMart](http://www.webservicemart.com/)
* BarCode - Demo app using [BarcodeGenerator](http://www.webservicex.net/ws/WSDetails.aspx?CATID=8&WSID=76) SOAP web serivce from webserviceX.NET
* HelloAmazonProductAdvertising - Hello world like sample using [Amazon Product Advertising API](https://affiliate-program.amazon.com/gp/advertising/api/detail/main.html) SOAP call.
* HelloeBayFinding - Hello world like sample using [eBay Finding API](https://www.x.com/developers/ebay/products/finding-api) SOAP call.
* HelloeBayShopping - Hello world like sample using [eBay Shopping API](https://www.x.com/developers/ebay/products/shopping-api) XML call.
* HelloeBayTrading - Hello world like sample using [eBay Trading API](https://www.x.com/developers/ebay/products/trading-api) SOAP call.
* AmazonBookFinder - Sample Amazon Book search and purchase app using Amazon Product Advertising API.
* eBayDemoApp - Sample eBay Search App using both eBay Finding API and eBay Shopping API.



##Docs for Web Service
1. [WSDL Driven Development on Android - the Big Picture](http://bulldog2011.github.io/blog/2013/04/15/wsdl-driven-development-on-android-the-big-picture/)
2. [Nano Tutorial 1 - a Number Conversion Sample](http://bulldog2011.github.io/blog/2013/04/15/nano-tutorial-1-a-number-conversion-sample/)
3. [Nano Tutorial 2 - a BarCode Generator Sample](http://bulldog2011.github.io/blog/2013/04/17/nano-tutorial-2-a-barcode-sample/)
4. [Nano Tutorial 3 - Hello eBay Finding Service](http://bulldog2011.github.io/blog/2013/04/17/nano-tutorial-3-hello-ebay-finding/)
5. [Nano Tutorial 4 - Hello eBay Shopping Service](http://bulldog2011.github.io/blog/2013/04/18/nano-tutorial-4-hello-ebay-shopping/)
6. [Nano Tutorial 5 - Hello Amazon Product Advertising API](http://bulldog2011.github.io/blog/2013/04/18/nano-tutorial-5-hello-amazon-product-advertising-api/)

##Docs for Binding
1. [Nano Hello World](http://bulldog2011.github.com/blog/2013/02/05/nano-hello-world/)
2. [Nano List Handling](http://bulldog2011.github.com/blog/2013/02/05/nano-list-tutorial/)
3. [Nano Compare to JAXB](http://bulldog2011.github.com/blog/2013/02/06/nano-compare-to-jaxb/)
4. [Scheam driven data binding with Nano and mxjc](http://bulldog2011.github.com/blog/2013/02/07/schema-driven-nano-binding/)
5. [Xml Parser and Nano Benchmark on Android](http://bulldog2011.github.com/blog/2013/02/08/nano-benchmark-on-android/)
6. [Nano on Android Tutorial 1](http://bulldog2011.github.com/blog/2013/02/10/nano-on-android-tutorial-1/)
7. [A full movie search Android application using Nano binding](http://bulldog2011.github.com/blog/2013/02/12/movie-search-android-app-using-nano/)
8. [Schema Driven Web Serivce Client Development on Android, Part 1 : Hello eBay Finding](http://bulldog2011.github.com/blog/2013/02/17/schema-driven-on-android-part-1-hello-ebay-finding/)
9. [Schema Driven Web Serivce Client Development on Android, Part 2 : eBay Search App](http://bulldog2011.github.com/blog/2013/02/19/schema-driven-on-android-part-2-ebay-search/)


##Mapping between XML Schema Types and Java Types 

|       XML Schema Data Types   |       Objective-C Data Types  |
|-------------------------------|-------------------------------|
|       xsd:base64Binary        |       byte[]                  |
|       xsd:boolean             |       boolean                 |
|       xsd:byte                |       byte                    |
|       xsd:date                |       java.util.Date          |
|       xsd:dateTime            |       java.util.Date          |
|       xsd:decimal             |       java.math.BigDecimal    |
|       xsd:double              |       double                  |
|       xsd:duration            |com.leansoft.nano.custom.types.Duration|
|       xsd:float               |       float                   |
|       xsd:g                   |       java.util.Date          |
|       xsd:hexBinary           |       byte[]                  |
|       xsd:int                 |       int                     |
|       xsd:integer             |       java.lang.BigInteger    |
|       xsd:long                |       long                    |
|       xsd:NOTATION            |   javax.xml.namespace.QName   |
|       xsd:Qname               |   javax.xml.namespace.QName   |
|       xsd:short               |       short                   |
|       xsd:string              |       java.lang.String        |
|       xsd:time                |       java.util.Date          |
|       xsd:unsignedByte        |       short                   |
|       xsd:unsignedInt         |       long                    |
|       xsd:unsignedShort       |       int                     |

## Version History

|       Version         |       Date            |       Description     |
|-----------------------|-----------------------|-----------------------|
|[0.7.0](https://github.com/bulldog2011/bulldog-repo/tree/master/repo/releases/com/leansoft/nano/0.7.0)|April 14, 2013  |Initial release supporting SOAP/XML Web Service.|
|[0.7.1](https://github.com/maxep/mvn-repo/tree/releases/com/leansoft/nano-kit/0.7.1)|April 16, 2015  | Upgrade to Android-15|

##Compatibility
NanoKit has been verified with Android 4.0.3(API 15).


##Current Limitation
1. Only Document/Literal style Web Service is support, RPC style Web Serivice is not supported.
2. SOAP attachment is not supported

## License

NanoKit is available under the Apache v2.0 license. See the [LICENSE](LICENSE) file for more info. 
