import { FrontendEbiPage } from './app.po';

describe('frontend-ebi App', () => {
  let page: FrontendEbiPage;

  beforeEach(() => {
    page = new FrontendEbiPage();
  });

  it('should display welcome message', done => {
    page.navigateTo();
    page.getParagraphText()
      .then(msg => expect(msg).toEqual('Welcome to app!!'))
      .then(done, done.fail);
  });
});
