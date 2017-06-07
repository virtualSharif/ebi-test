import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response, URLSearchParams} from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { Transcript } from '../dtos/transcript';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';

@Injectable()
export class TranscriptService {

    private options: RequestOptions;
    private transcriptURL = 'http://localhost:8080/api/v1/transcripts';

    constructor(private http: Http) { }

    setRequestOptions() {
        this.options = new RequestOptions({ headers: new Headers({ 'Content-Type': 'application/json' }) });
    }

    getTranscripts(symbol: string, position: number, aminoAcidLetter: string): Observable<Transcript[]> {
        this.setRequestOptions();
        let params: URLSearchParams = new URLSearchParams();
        params.set('symbol', symbol);
        params.set('position', String(position));
        params.set('aminoAcidLetter', aminoAcidLetter);
        this.options.search = params;
        return this.http.get(this.transcriptURL, this.options).map(response => response.json() || {});
    }

    getTranscriptsByHGSV(hgsvNotation): Observable<Transcript[]> {
        this.setRequestOptions();
        let params: URLSearchParams = new URLSearchParams();
        params.set('hgsvNotation', hgsvNotation);
        this.options.search = params;
        return this.http.get(this.transcriptURL + '/hgsv', this.options).map(response => response.json() || {});
    }

}
