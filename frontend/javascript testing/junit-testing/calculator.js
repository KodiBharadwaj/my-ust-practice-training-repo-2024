let add = (a, b) => {
    if(typeof a !== 'number' || typeof b !== 'number'){
        throw new Error('Invalid Input');
    }

    return a+b;
}

let subtract = (a, b) => {
    if(typeof a !== 'number' || typeof b !== 'number'){
        throw new Error("Invalid Input");
    }

    return a-b;
}

let multiply = (a, b) => {
    if(typeof a !== 'number' || typeof b !== 'number'){
        throw new Error("Invalid Input");
    }

    return a*b;
}

let divide = (a, b) => {
    if(typeof a !== 'number' || typeof b !== 'number'){
        throw new Error("Invalid Input");
    }

    if(b === 0){
        throw new Error("Cannot be divided by zero");
    }

    return a/b;
}



module.exports = {
    add,
    subtract,
    multiply,
    divide
}