# VersionAdapter

### A java Adapter for the [HttpVersionServer](https://github.com/Teddyw2000/Version-Http-Server)

## How to use
```java
//Create an instance
VersionAdapter versionAdapter = new VersionAdapter("http://localhost:3030/version?method=GET", UserAgent.MOZILLA_5_0);

//Get the version via Http
try {
   versionAdapter.getVersion(); 
} catch (IOException e) {
   System.out.println("[Error] Could not fetch version! | " + e.getMessage());
}
```

## Javascript Example
#### Using Javascript? No problem!
##### Here is an example using the fetch module from Node

```javascript
const fetch = require('node-fetch');

async function getVersion() {
    const response = await fetch('http://localhost:3030/version?method=GET');
    const data = await response.json();
    return data.version;
}

getVersion().then(e => {
    console.log(e);
});
```
