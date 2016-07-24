package com.icteam.loyalty.common.util;

import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Item;

public final class ControlUtils {

	//    public static void adjustLayout(final Composite c) {
	//        Display.getDefault().timerExec(100, new Runnable() {
	//            @Override
	//            public void run() {
	//                adjustLayoutInternal(c);
	//
	//                c.layout(true, true);
	//            }
	//        });
	//    }
	//
	//    static void adjustLayoutInternal(Control p) {
	//        if (p instanceof Composite) {
	//            Composite composite = (Composite) p;
	//            Layout layout = ((Composite) p).getLayout();
	//
	//            if (layout instanceof GridLayout) {
	//                GridLayout gridLayout = (GridLayout) layout;
	//
	//                Control[][] grid = buildGrid(composite, gridLayout);
	//
	//                int[] maxWidths = new int[grid.length];
	//                for (Control[] element : grid) {
	//                    for (int j = 0; j < element.length; j++) {
	//                        Control control = element[j];
	//
	//                        if (control instanceof ILabelControl) {
	//                            Label labelControl = ((ILabelControl) control).getLabelControl();
	//
	//                            Point size = labelControl.computeSize(SWT.DEFAULT, SWT.DEFAULT, true);
	//
	//                            maxWidths[j] = Math.max(maxWidths[j], size.x);
	//                        }
	//                    }
	//                }
	//
	//                for (Control[] element : grid) {
	//                    for (int j = 0; j < element.length; j++) {
	//                        Control control = element[j];
	//
	//                        if (control instanceof ILabelControl) {
	//                            Object layoutData = ((ILabelControl) control).getLabelControl().getLayoutData();
	//
	//                            if (layoutData instanceof FormData) {
	//                                ((FormData) layoutData).width = maxWidths[j];
	//                            } else if (layoutData instanceof GridData) {
	//                                ((GridData) layoutData).widthHint = maxWidths[j];
	//                                ((GridData) layoutData).minimumWidth = maxWidths[j];
	//                            }
	//                        }
	//                    }
	//                }
	//            }
	//
	//            for (Control control : composite.getChildren()) {
	//                adjustLayoutInternal(control);
	//            }
	//        }
	//    }

	private static Control[][] buildGrid(Composite composite, GridLayout gridLayout) {
		/* Build the grid */
		int row = 0, column = 0, rowCount = 0;
		final int columnCount = gridLayout.numColumns;
		Control[][] grid = new Control[4][columnCount];
		for (int i = 0; i < composite.getChildren().length; i++) {
			final Control child = composite.getChildren()[i];
			GridData data = (GridData) child.getLayoutData();
			if (data == null) {
				child.setLayoutData(data = new GridData());
			}
			final int hSpan = Math.max(1, Math.min(data.horizontalSpan, columnCount));
			final int vSpan = Math.max(1, data.verticalSpan);
			while (true) {
				final int lastRow = row + vSpan;
				if (lastRow >= grid.length) {
					final Control[][] newGrid = new Control[lastRow + 4][columnCount];
					System.arraycopy(grid, 0, newGrid, 0, grid.length);
					grid = newGrid;
				}
				if (grid[row] == null) {
					grid[row] = new Control[columnCount];
				}
				while (column < columnCount && grid[row][column] != null) {
					column++;
				}
				final int endCount = column + hSpan;
				if (endCount <= columnCount) {
					int index = column;
					while (index < endCount && grid[row][index] == null) {
						index++;
					}
					if (index == endCount) {
						break;
					}
					column = index;
				}
				if (column + hSpan >= columnCount) {
					column = 0;
					row++;
				}
			}
			for (int j = 0; j < vSpan; j++) {
				if (grid[row + j] == null) {
					grid[row + j] = new Control[columnCount];
				}
				for (int k = 0; k < hSpan; k++) {
					grid[row + j][column + k] = child;
				}
			}

			rowCount = Math.max(rowCount, row + vSpan);
			column += hSpan;
		}

		return grid;
	}

	public static void pack(final ColumnViewer columnViewer) {
		pack(columnViewer, false);
	}

	public static void pack(final ColumnViewer columnViewer, boolean async) {
		final Runnable runnable = () -> {
			final Control control = columnViewer.getControl();

			for (final Item column : TableTreeUtils.getColumns(control)) {
				// gestisco il filtro sulle colonne altrimenti il pack ne ripristina la dimensione
				final Object zeroLength = column.getData(ControlData.ZERO_LENGTH);

				if (zeroLength == null) {
					TableTreeUtils.pack(column);
				}
			}
		};

		if (async) {
			Display.getCurrent().timerExec(200, runnable);
		} else {
			runnable.run();
		}

	}

	public static void refresh(ColumnViewer columnViewer) {
		refresh(columnViewer, false);
	}

	public static void refresh(ColumnViewer columnViewer, boolean async) {
		columnViewer.refresh();

		pack(columnViewer, async);
	}

}
