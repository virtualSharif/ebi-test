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
        if (symbol) { params.set('symbol', symbol); }
        if (position) { params.set('position', String(position)); }
        if (aminoAcidLetter) { params.set('aminoAcidLetter', aminoAcidLetter); }
        this.options.search = params;

        return this.http.get(this.transcriptURL, this.options)
            .map(response => response.json() || {})
            .catch(this.handleError);
    }

    private handleError(error: Response | any) {
        let errMsg: string;
        if (error instanceof Response) {
            const body = error.json() || '';
            const err = body.error || JSON.stringify(body);
            errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
        } else {
            errMsg = error.message ? error.message : error.toString();
        }
        return Observable.throw(errMsg);
    }

}
