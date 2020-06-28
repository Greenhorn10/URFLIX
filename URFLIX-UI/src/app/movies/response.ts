import { Movie } from './movie';

export class Response{
    public page:number;
    public total_results: number;
    public total_pages: number;
    public results: Movie[];
}
