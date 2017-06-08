import { Component, OnInit } from '@angular/core';
import { TranscriptService } from '../../services/transcript.service';
import { Transcript } from '../../dtos/transcript';

@Component({
    selector: 'app-transcript',
    templateUrl: './transcript.component.html'
})
export class TranscriptComponent implements OnInit {

    public symbol: string;
    public position: number;
    public aminoAcidLetter: string;
    public hgsvNotation: string;
    public searchType: string = 'Basic';
    public isLoading: boolean = false;
    public contentText: string = '';
    public transcripts: Transcript[];
    constructor(private transcriptService: TranscriptService) { }

    ngOnInit() {
    }

    getTranscripts() {
        if (this.nonNull(this.symbol) && this.nonNull(this.aminoAcidLetter) && this.position > 0) {
            this.showLoading();
            this.transcriptService.getTranscripts(this.symbol, this.position, this.aminoAcidLetter).subscribe(
                data => {
                    this.isLoading = false;
                    this.transcripts = data;
                },
                error => {
                    this.handleError(error);
                });
        }
        else {
            this.handleInvalidInputField();
        }
    }

    getTranscriptsByHGSV() {
        if (this.nonNull(this.hgsvNotation)) {
            this.showLoading();
            this.transcriptService.getTranscriptsByHGSV(this.hgsvNotation).subscribe(
                data => {
                    this.isLoading = false;
                    this.transcripts = data;
                },
                error => {
                    this.handleError(error);
                });
        }
        else {
            this.handleInvalidInputField();
        }
    }

    clearOptions() {
        this.symbol = '';
        this.position = null;
        this.aminoAcidLetter = '';
        this.hgsvNotation = '';
        this.transcripts = null;
        this.contentText = '';
    }

    changeSearchType(type) {
        this.searchType = type;
        this.clearOptions();
    }

    openLink(id: string) {
        return window.open('http://www.ensembl.org/id/' + id);
    }

    private showLoading() {
        this.isLoading = true;
        this.contentText = '';
    }

    private handleInvalidInputField() {
        this.contentText = 'Please check input field(s)';
    }

    private nonNull(inputString: string): boolean {
        return (typeof inputString != 'undefined' && inputString) ? true : false;
    }

    private handleError(error: Response | any) {
        let errorBody = error.json();
        let message = 'Unknown exception occurred';
        if (errorBody.message) {
            message = errorBody.message;
        }
        this.contentText = message;
        this.isLoading = false;
    }
}
