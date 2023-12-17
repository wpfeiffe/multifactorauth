export class Activity {
  constructor(
    public start: string,
    public limit: string,
    public total: string,
    public data: ActivityData[]) {
  }
}

export class ActivityData {
  constructor(
    public id: string,
    public name: string) {

  }

}
