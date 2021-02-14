# XmlToTree
Parse a XML file or XML string and returns List&lt;XmlNode>

# jsontotable
This library converts json object or array to html table

[![](https://jitpack.io/v/sayemkcn/XmlToTree.svg)](https://jitpack.io/#sayemkcn/XmlToTree)

#### Maven
* Add Jitpack repository if not added already
```aidl
    <repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
	
```
* Add Dependency
```aidl
    <dependency>
	    <groupId>com.github.sayemkcn</groupId>
	    <artifactId>XmlToTree</artifactId>
	    <version>v0.1</version>
	</dependency>
```

#### Gradle
* Add Jitpack repository if not added already
```aidl
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
* Add Dependency
```aidl
	dependencies {
	        implementation 'com.github.sayemkcn:XmlToTree:v0.1'
	}
```

## Example

### Input
```aidl
<?xml version="1.0" encoding="utf-8" ?>
<company>
    <name>Servicito</name>
    <department>
        <name>IT Department</name>
        <employees>
            <employee>
                <name>Barak Obama</name>
                <age>55</age>
            </employee>
            <employee>
                <name>Donald Trump</name>
                <age>5</age>
            </employee>
        </employees>
    </department>
</company>

```

### Convert
```
List<XMLNode> nodes = XMLParser.parse(new File("test.xml"), null);
or
List<XMLNode> nodes = XMLParser.parse("--XML as string--", null);
```
if you want to add labels for certain attributes of xml file, you can pass a map (  Map<String,String)  )
For example, here
```
Map<String,String> labels = new HashMap();
map.put("department", "Department");
```
then
```
List<XMLNode> nodes = XMLParser.parse("--XML as string--", labels);
```
So department XMLNode object with `department` attribute will have label set as `Department`

`node.getLabel()` to get the label, it'll return the original name in case label is null.


## Output
![img.png](https://i.imgur.com/wozWTJN.png)
