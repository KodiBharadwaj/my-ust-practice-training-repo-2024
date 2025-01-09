// https://api.github.com/users/kodibharadwaj


// function fetchGithubUser(username){
//     const url = "https://api.github.com/users/";
//     fetch(url + username)
//     .then(response => response.json().then(data => console.log(data)))
//     .catch(error => console.log(error))
// }


async function fetchGithubUser(username){
    const url = "https://api.github.com/users/";
    let response = await fetch(url + username);

    let data = await response.json();

    console.log(data);
    return data;
}