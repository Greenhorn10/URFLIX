import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Movie } from '../movies/movie';
import { Location } from '@angular/common';

@Component({
  selector: 'app-about-movie',
  templateUrl: './about-movie.component.html',
  styleUrls: ['./about-movie.component.scss']
})
export class AboutMovieComponent implements OnInit {
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
      let aboutUrl = `tmdb/${id}`;
      this.http.get<Movie>(aboutUrl).subscribe(movie => {
        this.selectedMovie = movie
      });
  }

  back() {
    this.location.back();
  }
}
