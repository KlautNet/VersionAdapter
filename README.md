# VersionAdapter

### A Adapter for the HttpVersionServer

## How to use
```java
public static void main(String[] args) {
		VersionAdapter versionAdapter = new VersionAdapter("http://localhost:3030/version?method=GET", UserAgent.MOZILLA_5_0);
		try {
			versionAdapter.getVersion(); 
		} catch (IOException e) {
			System.out.println("[Error] Could not fetch version! | " + e.getMessage());
		}

	}
```

## Javascript Example
#### Using the Fetch module from Node

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
