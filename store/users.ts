export interface IUser{
    name: string;
}
class UsersStore{
    users: IUser[] = [];
}
export let usersStore:UsersStore = new UsersStore();