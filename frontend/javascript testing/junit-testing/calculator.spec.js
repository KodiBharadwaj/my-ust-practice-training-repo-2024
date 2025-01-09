const {add, subtract, multiply, divide} = require("./calculator");

test('add 1+2 to be 3', () => {
    expect(add(1,2)).toBe(3);
});

//passing the exact error message
test('When string is passed', () => {
    expect(() => add('1', '2')).toThrow("Invalid Input");
});

//not passing here 
test('test for exception', () => {
    expect(() => add('1', '2')).toThrow;
});



//subtract
test('subtract 3-1 to be 2', () => {
    expect(subtract(3,1)).toBe(2);
});

test('throw exception', () => {
    expect(() => subtract('1', '2')).toThrow;
});

//multiply
test('subtract 3*2 to be 6', () => {
    expect(multiply(3,2)).toBe(6);
});

test('throw exception', () => {
    expect(() => multiply('1', '2')).toThrow;
});

//divide
test('subtract 6/2 to be 3', () => {
    expect(divide(6,2)).toBe(3);
});

test('throw exception', () => {
    expect(() => divide('1', '2')).toThrow;
});

test('throw exception when divided by 0', () => {
    expect(() => divide(6, 2)).toThrow;
});
