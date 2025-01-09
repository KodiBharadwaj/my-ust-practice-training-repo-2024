var Person = /** @class */ (function () {
    //Creating constructor
    function Person(name, email, age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }
    //Creating method
    //Should not use function keyword while creating functions inside a class
    Person.prototype.print = function () {
        console.log(this);
    };
    return Person;
}());
var p = new Person("Kodi", "Bharadwaj.Kodi@ust.com", 21);
p.print();
