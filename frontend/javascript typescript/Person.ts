export class Person{
    //inside a class let, const and var and arrow functions are not possible to declare
    //can be declared inside a function
    //typescript doesn't support method overloading but can be achieved through optional
    // But overriding is allowed

    public name:string;
    public email:string;
    public age:number;

    //Creating constructor
    constructor(name, email, age){
        this.name = name;
        this.email = email;
        this.age = age;
    }

    //Shortcut to create data members and constructor
    // constructor(private name:string, private email:string, private age:number){}

    //Creating method
    //Should not use function keyword while creating functions inside a class
    print():void{
        console.log(this);
    }

}

// let p:Person = new Person("Kodi", "Bharadwaj.Kodi@ust.com", 21);
// p.print();

// let p:Personv = {
//     name:"Kodi",
//     email:"Bharadwaj.Kodi@ust.com",
//     age:21
// }

// class Emploee extends Person {

// }

