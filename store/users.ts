import { makeAutoObservable } from "mobx";
import { randomize } from "../utils/random";
export interface IUser{
    name:string;
}
class UsersStore{
    users:IUser[] = [];
    wins:IUser[] = [];
    constructor(){
        makeAutoObservable(this);
    }
    addUser(user:IUser):void{
        this.users.push(user);
    }
    clear():void{
        this.users = []
    }
    randomize():string{
        const index:number = randomize(0, this.users.length);
        return `${index + 1}. ${this.users[index]}`;
    }
}
export let usersStore:UsersStore = new UsersStore();