import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Movie } from './movie';

import {map} from 'rxjs/operators';
import { Response } from './response';
import { Genre } from './genre';
import { GenreResponse } from './genre-response';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-movies',
  templateUrl: './movies.component.html',
  styleUrls: ['./movies.component.scss']
})
export class MoviesComponent implements OnInit {
  public language='en';
  public movies:Observable<Movie[]>;
  private genres:Genre[]=[];
  private query:string;
  public title='Top Rated';

  constructor (private router:Router, private http: HttpClient,private route: ActivatedRoute) {
  }
  ngOnInit(): void {
    this.http.get<Genre[]>(`tmdb/genres`).toPromise().then(
      genre => this.genres = genre
    );
    this.route.params.subscribe(
      params => {
        this.query = params['value'];
      }
    )
    this.movies = this.getMovies();
  }

  getMovies(): Observable<Movie[]>{
    let moviesUrl = `tmdb`;
    if(this.query){
      moviesUrl=`tmdb/search?query=${this.query}`;
      this.title='Search Result';
    }

    return this.http.get<Movie[]>(moviesUrl).pipe(
      map(data => {
        for(let movieEntity of data){
          let genre_names:string[] = [];
          for(let id of movieEntity.genre_ids){
            genre_names.push(this.genres.filter(genre => genre.id === id)[0].name);
          }
          movieEntity.genre_names = genre_names;
        }
       return data;
      })
    );
  }
}
