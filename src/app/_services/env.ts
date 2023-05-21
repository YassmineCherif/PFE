import { Location } from '@angular/common';
export class Env {
    hostname: string;
    port: string;
    host:string
    constructor() {
        this.hostname = location.hostname;
        this.port = ""

        this.host=this.hostname+':'+this.port;
}
  }