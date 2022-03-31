import {Client} from './client';

export class Session {
  id: number;
  openSession: Date;
  closeSession: Date;
  client: Client;
}
