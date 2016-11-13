import { MinesweeperappPage } from './app.po';

describe('minesweeperapp App', function() {
  let page: MinesweeperappPage;

  beforeEach(() => {
    page = new MinesweeperappPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
