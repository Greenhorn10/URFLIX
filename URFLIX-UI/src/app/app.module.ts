import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MoviesComponent } from './movies/movies.component';
import { HttpClientModule, HTTP_INTERCEPTORS }    from '@angular/common/http';
import { AboutMovieComponent } from './about-movieEntity/about-movieEntity.component';
import { SearchComponent } from './search/search.component';
import { HeaderComponent } from './header/header.component';
import { BaseUrlInterceptor } from './interceptor/baseurl.interceptor';

@NgModule({
  declarations: [
    AppComponent,
    MoviesComponent,
    AboutMovieComponent,
    SearchComponent,
    HeaderComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [{
      provide: HTTP_INTERCEPTORS,
      useClass: BaseUrlInterceptor,
      multi: true,
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
