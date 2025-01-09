// tsc hello.ts
// node hello
var username = "Kodi";
var isDone = true;
var decimal = 2;
var color = "green";
var list = [1, 2, 3];
var list2 = [1, 2, 3];
//tuple
var x;
x = ["hello", 2];
console.log(x);
var Color;
(function (Color) {
    Color[Color["RED"] = 0] = "RED";
    Color[Color["GREEN"] = 1] = "GREEN";
    Color[Color["BLUE"] = 2] = "BLUE";
})(Color || (Color = {}));
;
var c = Color.BLUE;
//console.log(Color);
var value;
value = 10;
// never type
// function error(message : string) : never {
//     throw new Error(message);
// }
var value = "Kodi";
console.log(value);
