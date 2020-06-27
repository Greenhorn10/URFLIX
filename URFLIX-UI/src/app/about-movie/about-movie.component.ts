import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Movie } from '../movies/movieEntity';
import { Location } from '@angular/common';

@Component({
  selector: 'app-about-movieEntity',
  templateUrl: './about-movieEntity.component.html',
  styleUrls: ['./about-movieEntity.component.scss']
})
export class AboutMovieComponent implements OnInit {

  private url:string ="https://api.themoviedb.org/3/movieEntity/";
  private apiKey = '68b4fe2a513155a58dd0af4adacb281b';
  public language='en';
  public selectedMovie: Movie;
  private selectedMovieId:number;

  constructor(private route: ActivatedRoute, private http:HttpClient,
    private location: Location) { }

  ngOnInit(): void {
    this.route.params.subscribe(
      params => {
        this.selectedMovieId = params['id'];
      }
    )
    this.getAboutMovie(this.selectedMovieId);
  }

  getAboutMovie(id: number){
      let aboutUrl = `${this.url}${id}?api_key=${this.apiKey}&language=${this.language}`;
      this.http.get<Movie>(aboutUrl).subscribe(movieEntity => {
        this.selectedMovie = movieEntity
      });
  }

  back() {
    this.location.back();
  }
}
