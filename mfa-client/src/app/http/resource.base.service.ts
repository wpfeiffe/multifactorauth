import { HttpClient } from "@angular/common/http";

export class ResourceBaseService {
    constructor(
      protected httpClient: HttpClient,
      protected url: string,
      protected endpoint: string) {}
}
