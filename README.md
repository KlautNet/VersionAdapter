# VersionAdapter

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
