window.onload = function() {
  // タスクを用意
  var tasks = [
    {
    	id: 'id1',//学習項目id
    	name: '<a href="/studycurriculum/Detail?id=1">英単語1500個</a>',//科目名＋内容
    	description: '',
    	start: '2021-07',//期間
    	end: '2021-09',
    	progress: 30,//進捗率

    },
    {
    	id: 'id2',
    	name:'<a href="/studycurriculum/Detail?id=2">英文法</a>',
    	description: '年賀状も確認した上で連絡する',
    	start: '2021-07-4',
    	end: '2021-07-8',
    	progress: 100,
    },
    {
    	id: 'id3',
    	name: '<a href="/studycurriculum/Detail?id=3">英語過去問</a>',
    	description: 'みんなに稼働時間を記録してもらった上で請求を出す',
    	start: '2021-07-5',
    	end: '2021-07-16',
    	progress: 40,
    },
    {
    	id: 'id4',
    	name: '英語過去問',
    	description: 'まずはフレームワークのアップデートやる!',
    	start: '2021-07-5',
    	end: '2021-07-11',
    	progress: 50,
    },
    {
    	id: 'id5',
    	name: '世界史通史',
    	description: '各メンバーシートを記入してもらった上で 1on1',
    	start: '2021-07-12',
    	end: '2021-07-16',
    	progress: 20,
    },
{
    	id: 'id6',
    	name: 'おい！',
    	description: '各メンバーシートを記入してもらった上で 1on1',
    	start: '2021-07-21',
    	end: '2021-07-27',
    	progress: 35,
    },

  ];

  // gantt をセットアップ
  var gantt = new Gantt("#gantt", tasks, {

    // ダブルクリック時
    on_click: (task) => {
      console.log(task.description);
    },
    // 日付変更時
    on_date_change: (task, start, end) => {
      console.log(`${task.name}: change date`);
    },
    // 進捗変更時
    on_progress_change: (task, progress) => {
      console.log(`${task.name}: change progress to ${progress}%`);
    },

  });
};

