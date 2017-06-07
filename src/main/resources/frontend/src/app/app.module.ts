import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { AppRoutingModule } from './app-routing.module';
import { ReactiveFormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { TranscriptComponent } from './components/transcript/transcript.component';
import { NavbarComponent } from './components/navbar/navbar.component';

import { TranscriptService } from './services/transcript.service';

@NgModule({
    declarations: [
        AppComponent,
        TranscriptComponent,
        NavbarComponent
    ],
    imports: [
        BrowserModule,
        FormsModule,
        HttpModule,
        AppRoutingModule,
        ReactiveFormsModule
    ],
    providers: [
        TranscriptService
    ],
    bootstrap: [AppComponent]
})
export class AppModule { }
