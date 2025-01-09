const baseUrl = "http://localhost:8200/api/v1/users";

async function addDetails(details) {
    const response = await fetch(baseUrl, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(details)
    });
    const data = await response.json();
    return data;
}

async function getDetails() {
    const response = await fetch(baseUrl);
    const data = await response.json();
    return data;
}
