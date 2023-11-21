import { UserAccount } from "../users/user-account";

export class LoginRequest {
  constructor(
    public username: string,
    public password: string) {
  }
}

export class LoginResponse{
  constructor(
    public mfaEnabled: boolean,
    public loginSuccess: boolean,
    public message: string,
    public mfaToken: string,
    public userAccount: UserAccount) {
  }
}
