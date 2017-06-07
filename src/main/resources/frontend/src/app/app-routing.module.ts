import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { TranscriptComponent} from './components/transcript/transcript.component';

const routes: Routes = [
    {
        path: '',
        redirectTo: 'app/transcripts',
        pathMatch: 'full'
    },
    {
        path: 'app/transcripts',
        component: TranscriptComponent
    },
    {
        path: '**',
        component: TranscriptComponent
    }

];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
