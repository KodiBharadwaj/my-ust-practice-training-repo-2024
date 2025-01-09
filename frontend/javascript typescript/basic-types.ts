// tsc hello.ts
// node hello


let username:string = "Kodi";

let isDone:boolean = true;
let decimal: number = 2;
let color: string = "green";

let list:number[] = [1,2,3];
let list2:Array<number> = [1,2,3];

//tuple
let x:[string,number];
x = ["hello", 2];
console.log(x);

enum Color {RED, GREEN, BLUE};
let c: Color = Color.BLUE;

console.log(Color);

let value: number;
value = 10;

// never type
function error(message : string) : never {
    throw new Error(message);
}

let value : string|number = "Kodi";
console.log(value);


//types in function

function add(x:number, y: number):number{
    return x+y;
}

add(2,3);

function add2(x:number, y:number = 0): number{
    return x+y;
}

add2(2);

// Let's make y optional
function add3(x: number, y?:number):number{
    if(y){
        return x+y;
    }
    return x;
}

add3(2);