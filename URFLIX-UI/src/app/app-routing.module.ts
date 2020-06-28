import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MoviesComponent } from './movies/movies.component';
import { AboutMovieComponent } from './about-movie/about-movie.component';
import { SearchComponent } from './search/search.component';


const routes: Routes = [
  {path:'', component:MoviesComponent},
  {path:'about-movie/:id', component:AboutMovieComponent},
  {path:'search', component:SearchComponent},
  {path:'search/:value', component: MoviesComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes,{useHash : true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
